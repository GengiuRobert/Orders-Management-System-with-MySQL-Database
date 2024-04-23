package DataAccess;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.ConnectionFactory;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 * @Source http://www.java-blog.com/mapping-javaobjects-database-reflection-generics
 */


public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    public String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    public String createFindAllQuery(){
        return "SELECT * FROM " + type.getSimpleName().toLowerCase()+";";
    }

    public T createObject(ResultSet resultSet) throws SQLException {
        Constructor<T> ctor = null;
        try {
            ctor = type.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        ctor.setAccessible(true);
        T instance = null;
        try {
            instance = ctor.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        for (Field field : type.getDeclaredFields()) {
            String fieldName = field.getName();
            Object value = resultSet.getObject(fieldName);
            PropertyDescriptor propertyDescriptor = null;
            try {
                propertyDescriptor = new PropertyDescriptor(fieldName, type);
            } catch (IntrospectionException e) {
                throw new RuntimeException(e);
            }
            Method method = propertyDescriptor.getWriteMethod();
            try {
                method.invoke(instance, value);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }

        return instance;
    }

    public List<T> findAll() {
        List<T> resultList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(createFindAllQuery());
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                T instance = createObject(resultSet);
                resultList.add(instance);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return resultList;
    }

    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String createInsertQuery(T tableName) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(tableName.getClass().getSimpleName().toLowerCase());
        sb.append(" (");

        Field[] fields = tableName.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            sb.append(fields[i].getName().toLowerCase());
            System.out.println(fields[i].getName().toLowerCase());
            if (i < fields.length - 1) {
                sb.append(", ");
            }
        }

        sb.append(") VALUES (");
        try {
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                Object value = fields[i].get(tableName);
                if (value instanceof String) {
                    sb.append("'").append(value).append("'");
                } else {
                    sb.append(value);
                }
                if (i < fields.length - 1) {
                    sb.append(", ");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        sb.append(");");
        return sb.toString();
    }

    public T insert(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            String insertQuery = createInsertQuery(t);
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(insertQuery);
            statement.executeUpdate();
            LOGGER.log(Level.INFO, "Record inserted successfully!");
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error inserting record: " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return t;
    }

    public String createUpdateQuery(T tableName) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(tableName.getClass().getSimpleName().toLowerCase());
        sb.append(" SET ");

        Field[] fields = tableName.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            Object value;
            try {
                value = fields[i].get(tableName);
                if (value != null) {
                    sb.append(fields[i].getName()).append(" = ");
                    if (value instanceof String) {
                        sb.append("'").append(value).append("'");
                    } else {
                        sb.append(value);
                    }
                    if (i < fields.length - 1) {
                        sb.append(", ");
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        sb.append(" WHERE id = ");
        try {
            Field idField = tableName.getClass().getDeclaredField("id");
            idField.setAccessible(true);
            Object idValue = idField.get(tableName);
            sb.append(idValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        sb.append(";");
        return sb.toString();
    }

    public void update(T t) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            String updateQuery = createUpdateQuery(t);
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(updateQuery);
            statement.executeUpdate();
            LOGGER.log(Level.INFO, "Record updated successfully!");
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error updating record: " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    public String createDeleteQuery() {
        return "DELETE FROM " + type.getSimpleName().toLowerCase() + " WHERE id = ?";
    }

    public void delete(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            String deleteQuery = createDeleteQuery();
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(deleteQuery);
            Field idField = t.getClass().getDeclaredField("id");
            idField.setAccessible(true);
            Object idValue = idField.get(t);
            statement.setInt(1, (int) idValue);
            statement.executeUpdate();
            LOGGER.log(Level.INFO, "Record with ID " + idValue + " deleted successfully!");
        } catch (SQLException | NoSuchFieldException | IllegalAccessException e) {
            LOGGER.log(Level.WARNING, "Error deleting record: " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }
}
