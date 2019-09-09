package dao.test;

import dao.ReplayDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")

public class ReplayDAOImplTest {
    @Autowired
    private ReplayDAO replayDAO;
    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete() {
        try {
            System.out.println(replayDAO.delete(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}