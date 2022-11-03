package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class TesteGenericDAO extends GenericDAO{
    protected ArrayList<Object> objects;

    public TesteGenericDAO(Connection con, String tabela) {
        super(con, tabela);
        this.loadObjects();
    }

    protected abstract void setStatementValues(PreparedStatement stmt, Object object) throws SQLException;
    protected abstract Object createObject(ResultSet rs) throws SQLException;
    protected abstract Object convertObject(Object object);

    @SuppressWarnings("unchecked")
    protected void loadObjects() throws NullPointerException {
        this.objects = super.findAll();
    }

    @SuppressWarnings("rawtypes")
    protected ArrayList getObjects() {
        return this.objects;
    }

    @Override
    public void update(Object object) {
        super.update(object);
        this.loadObjects();
    }

//    @Override
//    public void delete(ObjectWithID object) {
//        super.delete(object);
//        this.loadObjects();
//    }

    @Override
    public void insert(Object object) {
        super.insert(object);
        this.objects.add(this.convertObject(object));
    }
}
