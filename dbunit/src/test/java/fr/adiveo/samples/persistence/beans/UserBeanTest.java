package fr.adiveo.samples.persistence.beans;

import fr.adiveo.samples.helper.PersistenceMocker;
import fr.adiveo.samples.persistence.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UserBeanTest extends PersistenceMocker {
    @InjectMocks
    @Spy
    private UserBean userBean = new UserBean();

    @Spy
    private EntityManager em = entityManager;
    @BeforeEach
    public  void initDataSet() throws Exception {
        importDataSet("src/test/resources/User.xml");
    }

    @Test
    public  void test_listAllUser()  {

        List<User> users  =   userBean.listAllUsers() ;
        assertEquals(1,users.size());
        User user1  = users.get(0);
        assertEquals("USER1",user1.getId());
        assertEquals("AKRAM",user1.getFirstName());
        assertEquals("ADIVEO",user1.getLastName());
        assertEquals(LocalDateTime.of(2020, 5,20,10, 0),user1.getConnectionDate());

    }

}