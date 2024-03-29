package info.helloworld.sbmt.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import info.helloworld.sbmt.entity.User;

/**
 * DBへのアクセスメソッドを呼び出すDao
 * @author aoi
 *
 */
@Repository
public class LoginUserDao {
	
	@Autowired
	EntityManager em;
	
	/**
	 * フォームの入力値から該当するユーザを検索 合致するものが無い場合Nullが返される
	 * @param userName
	 * @return 一致するユーザが存在するとき:UserEntity、存在しないとき:Null
	 */
	public User findUser(String userName) {
		String query = "";
		query += "SELECT * ";
		query += "FROM user ";
		query += "WHERE username = :userName "; //setParameterで引数の値を代入できるようにNamedParameterを利用
		
		//EntityManagerで取得された結果はオブジェクトとなるので、LoginUser型へキャストが必要となる
		return (User)em.createNativeQuery(query, User.class).setParameter("userName", userName)
				.getSingleResult();
	}

}