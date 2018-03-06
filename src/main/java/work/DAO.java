package work;

import com.sun.istack.internal.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Service
public class DAO {
    private final EntityManager em;
    @Autowired
    public DAO(EntityManager em) {
        this.em = em;
    }
    public List<Model> all() {
        return em.createQuery("select p from Model p").getResultList();
    }
    @Nullable
    public Model find( String name) {
        try {
            return (Model) em.createQuery("select p from Model p where p.name = :name").
                    setParameter("name", name).getSingleResult();
        } catch (NoResultException notFound){
            return null;
        }
    }
    public void createModel(String login,String name) throws Throwable {
        em.getTransaction().begin();
        try {
           Model model=new Model();
            model.setLogin(login);
            model.setName(name);
            em.persist(model);
            em.getTransaction().commit();
        }
        catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        }
    }
}
