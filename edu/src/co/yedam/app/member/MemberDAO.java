package co.yedam.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import co.yedam.app.common.ConnectionManager;

public class MemberDAO {

	// 등록
	public int memberInsert(MemberVO member) {
		int r = 0;
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "insert into member (id, pwd, name, hobby,  gender, religion, introduction, regdt)"
					+ " values ( ?, ?, ?, ?, ?, ?, ?, sysdate)";

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPwd());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getHobby());
			psmt.setString(5, member.getGender());
			psmt.setString(6, member.getReligion());
			psmt.setString(7, member.getIntroduction());

			r = psmt.executeUpdate();

			// 4. 결과처리
			System.out.println(r + " 건이 등록됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}

		return r;
	}

	// 한건조회
	public MemberVO getMember(String id) {
		MemberVO vo = new MemberVO();
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리 준비
			String sql = "select * from member where id=?";
			psmt = conn.prepareStatement(sql);
			// 3. statement 실행
			psmt.setString(1, id); // 첫번재 물음표 값이 id다
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setGender(rs.getString("gender"));
				vo.setHobby(rs.getString("hobby"));
				vo.setIntroduction(rs.getString("introduction"));
				vo.setName(rs.getString("name"));
				vo.setPwd(rs.getString("pwd"));
				vo.setReligion(rs.getString("religion"));
				vo.setRegdt(rs.getString("regdt")); // 결과값에 담기
			}
			// 4. 결과 저장
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}
		return vo;
	}

	// 수정
	public int memberUpdate(MemberVO member) {
		int r = 0;
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "update member set pwd=?, name=?, "
							+ "hobby=?,  gender=?, religion=?, "
							+ "introduction=?"
						+ " where id=?"; //id는 pk라서 수정불가
					
					

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(7, member.getId());
			psmt.setString(1, member.getPwd());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getHobby());
			psmt.setString(4, member.getGender());
			psmt.setString(5, member.getReligion());
			psmt.setString(6, member.getIntroduction());

			r = psmt.executeUpdate();

			// 4. 결과처리
			System.out.println(r + " 건이 등록됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}

		return r;
	}

}
