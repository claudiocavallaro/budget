package com.example.testdb.demodb.persistence;

import com.example.testdb.demodb.model.Metodo;
import com.example.testdb.demodb.model.PagamentoEffettuato;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO {

    private static final PagamentoDAO INSTANCE = new PagamentoDAO();
    private static final String SELECT_ALL = "select pe.id, pe.importo , pe.note , pe.\"data\", m.tipo \n" +
            "from budget.pagamento_effettuato pe, budget.metodo m \n" +
            "where pe.metodo = m.id ";

    private static final String INSERT = "INSERT INTO budget.pagamento_effettuato\n" +
            "(importo, note, data, metodo)\n" +
            "VALUES( ?, ? , TO_DATE(?, 'yyyy-MM-dd') , ?);\n";

    private PagamentoDAO() {
    }

    public static PagamentoDAO getInstance() {
        return INSTANCE;
    }

    public List<PagamentoEffettuato> get() {
        final List<PagamentoEffettuato> pagamenti = new ArrayList<>();
        try (final Connection conn = DBManager.createConnection();
             final PreparedStatement statement = conn.prepareStatement(SELECT_ALL);) {

            statement.execute();
            ResultSet result = statement.getResultSet();

            while (result.next()) {
                final PagamentoEffettuato pagamento = new PagamentoEffettuato();

                pagamento.setId(result.getLong("id"));
                pagamento.setData(result.getDate("data").toString());
                pagamento.setImporto(result.getBigDecimal("importo").toString());
                pagamento.setMetodo(result.getString("tipo"));
                pagamento.setNote(result.getString("note"));
                pagamenti.add(pagamento);

            }
        } catch (SQLException s) {
            s.printStackTrace();
        }

        return pagamenti;
    }

    public boolean insert(String importo, String note, String data, Long metodo) {
        boolean flag = true;
        try (final Connection conn = DBManager.createConnection();
             final PreparedStatement statement = conn.prepareStatement(INSERT);) {

            statement.setBigDecimal(1, new BigDecimal(importo));
            statement.setString(2, note);
            statement.setString(3, data);
            statement.setLong(4, metodo);
            statement.execute();

        }catch(SQLException s) {
            s.printStackTrace();
            flag = false;
        }
        return flag;
    }
}
