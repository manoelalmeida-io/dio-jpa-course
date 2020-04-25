import model.Aluno;
import model.Estado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ExecutionPart1 {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part1-DIO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Estado estadoParaAdicionar = new Estado("Rio de Janeiro", "RJ");
        Aluno alunoParaAdicionar = new Aluno("Daniel", 29, estadoParaAdicionar);

        entityManager.getTransaction().begin();

        entityManager.persist(estadoParaAdicionar);
        entityManager.persist(alunoParaAdicionar);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
