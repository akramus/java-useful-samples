package fr.adiveo.samples.helper;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;

public class PersistenceMocker {

    protected static EntityManager entityManager;
    private static EntityManagerFactory emf;

    private static final String JDBC_DRIVER = org.h2.Driver.class.getName();

    private static final String JDBC_URL = "jdbc:h2:mem:test";

    private static final String PASSWORD = "";

    private static final String USER = "sa";

    @BeforeAll
    public static void createSchema() {
        emf = Persistence.createEntityManagerFactory("test");
        entityManager = emf.createEntityManager();
    }


    @AfterAll
    public static void destroySchema() {
        entityManager.close();
        emf.close();
    }


    protected  void importDataSet(final String dataPath) throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().setColumnSensing(true).build(new File(dataPath));
        IDatabaseTester databaseTester = new JdbcDatabaseTester(JDBC_DRIVER, JDBC_URL, USER, PASSWORD);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }


}
