package com.lyonbank.LyonBank.dao;

import com.lyonbank.LyonBank.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    @Transactional
    public List<User> getUsers() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class,id);
        entityManager.remove(user);

    }

    @Override
    public void register(User user) {
        entityManager.merge(user);
    }

    @Override
    public User checkInfo(User usuario) {
        String query = "FROM User WHERE email = :email";
        List<User> list = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if (list.isEmpty()) {
            System.out.println("The list is empty");
            return null;
        }

        System.out.println("The list isn't empty");
        String passwordHashed = list.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, usuario.getPassword())) {
            System.out.println("The password is ok");
            return list.get(0);
        }
        System.out.println("The password isn't ok");
        return null;
    }
}
