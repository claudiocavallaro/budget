package com.example.testdb.demodb.persistence;

import com.example.testdb.demodb.model.PagamentoEffettuato;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO {

    private Logger logger = LogManager.getLogger(PagamentoDAO.class);

    private static final PagamentoDAO INSTANCE = new PagamentoDAO();
    private static final String SELECT = "select pe.id, pe.importo , pe.note , pe.\"data\", m.tipo \n" +
            "from budget.pagamento_effettuato pe, budget.metodo m \n" +
            "where pe.metodo = m.id ";

    private static final String INSERT = "INSERT INTO budget.pagamento_effettuato\n" +
            "(importo, note, data, metodo)\n" +
            "VALUES( ?, ? , TO_DATE(?, 'yyyy-MM-dd') , ?);\n";

    private static final String SELECT_MONTH_WHERE = " and date_part('month', pe.data) = ?";

    private PagamentoDAO() {
    }

    public static PagamentoDAO getInstance() {
        return INSTANCE;
    }

    public List<PagamentoEffettuato> getMonth(String month) {
        final List<PagamentoEffettuato> pagamenti = new ArrayList<>();
        try (final Connection conn = DBManager.createConnection();
             final PreparedStatement statement = conn.prepareStatement(SELECT + SELECT_MONTH_WHERE);) {

            statement.setInt(1, Integer.valueOf(month));
            statement.execute();
            ResultSet result = statement.getResultSet();

            while (result.next()) {
                final PagamentoEffettuato pagamento = new PagamentoEffettuato();

                pagamento.setId(result.getLong("id"));
                pagamento.setData(result.getDate("data").toString());
                pagamento.setImporto(result.getBigDecimal("importo"));
                pagamento.setMetodo(result.getString("tipo"));
                pagamento.setNote(result.getString("note"));
                pagamenti.add(pagamento);

            }
        } catch (SQLException s) {
            s.printStackTrace();
        }

        return pagamenti;
    }

    public List<PagamentoEffettuato> get() {
        final List<PagamentoEffettuato> pagamenti = new ArrayList<>();
        try (final Connection conn = DBManager.createConnection();
             final PreparedStatement statement = conn.prepareStatement(SELECT);) {

            statement.execute();
            ResultSet result = statement.getResultSet();

            while (result.next()) {
                final PagamentoEffettuato pagamento = new PagamentoEffettuato();

                pagamento.setId(result.getLong("id"));
                pagamento.setData(result.getDate("data").toString());
                pagamento.setImporto(result.getBigDecimal("importo"));
                pagamento.setMetodo(result.getString("tipo"));
                pagamento.setNote(result.getString("note"));
                pagamenti.add(pagamento);

            }
        } catch (SQLException s) {
            s.printStackTrace();
        }

        return pagamenti;
    }

    public boolean insert(BigDecimal importo, String note, String data, Long metodo) {
        boolean flag = true;
        try (final Connection conn = DBManager.createConnection();
             final PreparedStatement statement = conn.prepareStatement(INSERT);) {

            statement.setBigDecimal(1, importo);
            statement.setString(2, note);
            statement.setString(3, data);
            statement.setLong(4, metodo);
            statement.execute();

        }catch(SQLException s) {
            logger.error("Formato data non corretto !! Usare yyyy-MM-dd");
            s.printStackTrace();
            flag = false;
        }
        return flag;
    }
}
