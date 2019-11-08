package info.helloworld.sbmt.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import info.helloworld.sbmt.domain.User;

/**
 * DBへのアクセスメソッドを呼び出すDao
 * @author aoi
 *
 */
@Repository
public class UserDao {
	
	@Autowired
	EntityManager em;
	
	/**
	 * フォームの入力値から該当するユーザを検索 合致するものが無い場合Nullが返される
	 * @param userName
	 * @return 一致するユーザが存在するとき:UserEntity、存在しないとき:Null
	 */
	public User findUser(String userId) {
		String query = "";
		query += "SELECT * ";
		query += "FROM user_table ";
		query += "WHERE userid = :userId "; //setParameterで引数の値を代入できるようにNamedParameterを利用
		
		//EntityManagerで取得された結果はオブジェクトとなるので、LoginUser型へキャストが必要となる
		return (User)em.createNativeQuery(query, User.class).setParameter("userId", userId)
				.getSingleResult();
	}

}
