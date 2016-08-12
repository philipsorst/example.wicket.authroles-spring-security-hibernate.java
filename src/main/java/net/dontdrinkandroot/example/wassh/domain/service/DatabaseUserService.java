package net.dontdrinkandroot.example.wassh.domain.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import net.dontdrinkandroot.example.wassh.domain.model.Role;
import net.dontdrinkandroot.example.wassh.domain.model.User;


public class DatabaseUserService implements UserService
{

	private EntityManager entityManager;

	private PasswordEncoder passwordEncoder;


	protected DatabaseUserService()
	{
		/* Reflection instantiation */
	}

	public DatabaseUserService(PasswordEncoder passwordEncoder)
	{
		this.passwordEncoder = passwordEncoder;
	}

	@PersistenceContext
	public void setEntityManager(final EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	@Transactional(readOnly = true)
	public User loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = this.findUserByUsername(username);
		if (null == user) {
			throw new UsernameNotFoundException("The given user was not found");
		}

		return user;
	}

	@Override
	@Transactional(readOnly = true)
	public User findUserByUsername(String username)
	{
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("username"), username));
		TypedQuery<User> query = this.entityManager.createQuery(criteriaQuery);
		List<User> resultList = query.getResultList();
		if (resultList.isEmpty()) {
			return null;
		}
		if (resultList.size() > 1) {
			throw new NonUniqueResultException();
		}

		return resultList.iterator().next();
	}

	@Override
	@Transactional
	public User create(String username, String password, Role role)
	{
		User user = new User(username, this.passwordEncoder.encode(password), role);
		this.entityManager.persist(user);

		return user;
	}
}
