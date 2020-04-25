import model.Aluno;
import model.Estado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ExecutionPart3 {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part2-DIO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Estado estadoParaAdicionar = new Estado("Rio de Janeiro", "RJ");
        Aluno alunoParaAdicionar = new Aluno("Daniel", 29, estadoParaAdicionar);
        Aluno alunoParaAdicionar2 = new Aluno("Marcos", 25, estadoParaAdicionar);
        Aluno alunoParaAdicionar3 = new Aluno("João", 19, estadoParaAdicionar);

        entityManager.getTransaction().begin();

        entityManager.persist(estadoParaAdicionar);
        entityManager.persist(alunoParaAdicionar);
        entityManager.persist(alunoParaAdicionar2);
        entityManager.persist(alunoParaAdicionar3);

        entityManager.getTransaction().commit();

        String sql = "SELECT * FROM Aluno WHERE nome = :nome";
        Aluno alunoSQL = (Aluno) entityManager
                .createNativeQuery(sql, Aluno.class)
                .setParameter("nome", "Daniel")
                .getSingleResult();

        String sqlList = "SELECT * FROM Aluno";
        List<Aluno> alunoSQLList = entityManager
                .createNativeQuery(sqlList, Aluno.class)
                .getResultList();

        System.out.println("Consulta alunoSQL: " + alunoSQL);
        alunoSQLList.forEach(System.out::println);

        String jpql = "SELECT a FROM Aluno a WHERE a.nome = :nome";
        Aluno alunoJPQL = entityManager
                .createQuery(jpql, Aluno.class)
                .setParameter("nome", "Daniel")
                .getSingleResult();

        String jpqlList = "SELECT a FROM Aluno a";
        List<Aluno> alunoJPQLList = entityManager
                .createQuery(jpqlList, Aluno.class)
                .getResultList();

        System.out.println("Consulta aluno JPQL: " + alunoJPQL);
        alunoJPQLList.forEach(System.out::println);
    }
}
