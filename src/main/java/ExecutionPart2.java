import model.Aluno;
import model.Estado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ExecutionPart2 {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part2-DIO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Estado estadoParaAdicionar = new Estado("Rio de Janeiro", "RJ");
        Aluno alunoParaAdicionar = new Aluno("Daniel", 29, estadoParaAdicionar);

        entityManager.getTransaction().begin();

        entityManager.persist(estadoParaAdicionar);
        entityManager.persist(alunoParaAdicionar);

        entityManager.getTransaction().commit();

        Estado estadoEncontrado = entityManager.find(Estado.class, 1);
        Aluno alunoEncontrado = entityManager.find(Aluno.class, 1);

        System.out.println(estadoEncontrado);
        System.out.println(alunoEncontrado);

        entityManager.getTransaction().begin();

        alunoEncontrado.setNome("Maria");

        entityManager.getTransaction().commit();

        System.out.println(entityManager.find(Aluno.class, 1));

        entityManager.close();
        entityManagerFactory.close();
    }
}
