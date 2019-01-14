package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.studentBean;
import extraBean.studenteditBean;
import extraBean.studentgradeBean;
import extraBean.studentsubmitBean;
import tableOperation.stduentTrainOperation;
import tableOperation.studentOperation;
import util.DBUtil;

public class studentDao {
	public int Inquire(String id , String password) throws ClassNotFoundException, SQLException{ //登陆验证
		
		Connection conn = DBUtil.getConnection();
			String sql = "select * from student where student_id = ? and password = ?";
			int i = -1;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				i = 0;
			}
			DBUtil.freeConnection(conn);
			return i;
}
	
		public studentBean QueryInfo(String id) throws SQLException {//查询信息
			studentBean studentBean = new studentBean();
			Connection conn = DBUtil.getConnection();
			String sql = "select * from student where student_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				studentBean.setStudentId(rs.getString("student_id"));
				studentBean.setStudentsName(rs.getString("student_name"));
				studentBean.setSex1(rs.getInt("sex"));
				studentBean.setMajor(rs.getString("major"));
				studentBean.setStudentQq(rs.getString("student_qq"));
				studentBean.setStudentPhone(rs.getString("student_phone"));
			}
			DBUtil.freeConnection(conn);
			return studentBean;
		}
		
		public int updatePassword(String studentId, String password) throws SQLException {//更改密码
			studentOperation studentOperation = new studentOperation();
			int i = 0;
			i = studentOperation.updatePassword(studentId, password);
			return i;
		}
		
		public int addDetails(String studentId,int trainId,String province,String city,String company,String contactName,String contactPhone)throws SQLException{//增加实训信息
			stduentTrainOperation stduentTrainOperation = new stduentTrainOperation();
			int i = 0;
			i = stduentTrainOperation.addDetails(studentId, trainId, province, city, company, contactName, contactPhone);
			return i;

		}

		public int trainId() throws SQLException{//求最后的实训号
			stduentTrainOperation stduentTrainOperation = new stduentTrainOperation();
			int trainId = stduentTrainOperation.selectTrainId();
			return trainId;
		}
		
		public int updateStudent(String studentId,String studentPhone, String studentQq) throws SQLException {//更改学生表的信息
			 Connection conn = DBUtil.getConnection();
		        int result = 0;
		        if (conn != null) {
		            String sql = "UPDATE student  set  student_phone=?,student_qq=?  where student_id=?";
		            PreparedStatement pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1, studentPhone);
		            pstmt.setString(2, studentQq);
		            pstmt.setString(3, studentId);
		            result = pstmt.executeUpdate();
		            System.out.println(sql);
		            System.out.println();
		        }
		        DBUtil.freeConnection(conn);
		        return result;
		}

		public  List<studentgradeBean> listEmployee(String studentId) throws SQLException {//查看学生成绩
			List<studentgradeBean> list = new ArrayList<studentgradeBean>();
			Connection conn = DBUtil.getConnection();
			if (conn != null) {
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				String sql="SELECT * FROM shixi, shixireport,teacher WHERE ( shixireport.shixi_id = shixi.shixi_id ) AND teacher.teacher_id=shixi.teacherId AND teacher.teacher_id = shixi.teacherId"+
				" AND shixireport.student_id = "+studentId;
				
				ResultSet rs = stmt.executeQuery(sql);
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					studentgradeBean bean = new studentgradeBean();
					bean.setTrainId(rs.getInt("train_id"));
					bean.setTeacherName(rs.getString("teacher_name"));
					bean.setWeek(rs.getString("week"));
					bean.setGrade(rs.getFloat("grade"));
					bean.setOpinion(rs.getString("opinion"));
					bean.setStage("实习阶段");
					list.add(bean);
				}
				String sql1="SELECT * FROM shixun, shixunreport,teacher WHERE ( shixunreport.shixun_id = shixun.shixun_id ) AND teacher.teacher_id=shixun.teacherId AND teacher.teacher_id = shixun.teacherId"+
						" AND shixunreport.student_id = "+studentId;
						
						ResultSet rs1 = stmt.executeQuery(sql1);
						rs1 = stmt.executeQuery(sql1);
						while (rs1.next()) {
							studentgradeBean bean = new studentgradeBean();
							bean.setTrainId(rs1.getInt("train_id"));
							bean.setTeacherName(rs1.getString("teacher_name"));
							bean.setWeek(rs1.getString("week"));
							bean.setGrade(rs1.getFloat("grade"));
							bean.setOpinion(rs1.getString("opinion"));
							bean.setStage("实训阶段");
							list.add(bean);
						}
						
						String sql2="SELECT * FROM shijian, shijianreport,teacher WHERE ( shijianreport.shijian_id = shijian.shijian_id ) AND teacher.teacher_id=shijian.teacherId AND teacher.teacher_id = shijian.teacherId"+
								" AND shijianreport.student_id = "+studentId;
								
								ResultSet rs2 = stmt.executeQuery(sql2);
								rs2 = stmt.executeQuery(sql2);
								while (rs2.next()) {
									studentgradeBean bean = new studentgradeBean();
									bean.setTrainId(rs2.getInt("train_id"));
									bean.setTeacherName(rs2.getString("teacher_name"));
									bean.setWeek(rs2.getString("week"));
									bean.setGrade(rs2.getFloat("grade"));
									bean.setOpinion(rs2.getString("opinion"));
									bean.setStage("实践阶段");
									list.add(bean);
								}
				
			}
			DBUtil.freeConnection(conn);
			
			return list;
			
		}

		public float allGrade(String studentId) throws SQLException{//查询学生总成绩
			float i = 0;
			Connection conn = DBUtil.getConnection();
			String sql = "select grade from student where student_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, studentId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				i = rs.getFloat("grade");
			}
			return i;
		}
		
		public  List<studentsubmitBean> listSubmit(String studentId) throws SQLException {//查看报告情况
			List<studentsubmitBean> list = new ArrayList<studentsubmitBean>();
			Connection conn = DBUtil.getConnection();
			if (conn != null) {
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				String sql="SELECT shixi.train_id, shixireport.begin_time, shixireport.end_time, "
						+ "shixireport.WEEK FROM shixi,shixireport "
						+ "WHERE shixi.shixi_id = shixireport.shixi_id"
						+ " AND shixireport.student_id = "+studentId;
				
				ResultSet rs = stmt.executeQuery(sql);
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					studentsubmitBean bean = new studentsubmitBean();
					bean.setTrainId(rs.getInt("train_id"));
					bean.setStage("实习阶段");
					bean.setBeginTime(rs.getDate("begin_time"));
					bean.setEndTime(rs.getDate("end_time"));
					bean.setWeek(rs.getInt("week"));
					list.add(bean);
				}
				String sql1="SELECT shixun.train_id, shixunreport.begin_time, shixunreport.end_time, "
						+ "shixunreport.WEEK FROM shixun,shixunreport "
						+ "WHERE shixun.shixun_id = shixunreport.shixun_id"
						+ " AND shixunreport.student_id = "+studentId ;
				
				ResultSet rs1 = stmt.executeQuery(sql1);
				rs1 = stmt.executeQuery(sql1);
				while (rs1.next()) {
					studentsubmitBean bean = new studentsubmitBean();
					bean.setTrainId(rs1.getInt("train_id"));
					bean.setStage("实训阶段");
					bean.setBeginTime(rs1.getDate("begin_time"));
					bean.setEndTime(rs1.getDate("end_time"));
					bean.setWeek(rs1.getInt("week"));
					list.add(bean);
						}
						
				String sql2="SELECT shijian.train_id, shijianreport.begin_time, shijianreport.end_time, "
						+ "shijianreport.WEEK FROM shijian,shijianreport "
						+ "WHERE shijian.shijian_id = shijianreport.shijian_id"
						+ " AND shijianreport.student_id = "+studentId ;
				
				ResultSet rs2 = stmt.executeQuery(sql2);
				rs2 = stmt.executeQuery(sql2);
				while (rs2.next()) {
					studentsubmitBean bean = new studentsubmitBean();
					bean.setTrainId(rs2.getInt("train_id"));
					bean.setStage("实践阶段");
					bean.setBeginTime(rs2.getDate("begin_time"));
					bean.setEndTime(rs2.getDate("end_time"));
					bean.setWeek(rs2.getInt("week"));
					list.add(bean);
			}

		}
			DBUtil.freeConnection(conn);
			return list;
			}
	
		public int storage(String studentId,String tableName ,String data,String address) throws SQLException{//提交报告地址
			Connection conn = DBUtil.getConnection();
			int result = 0;
			String sql = "UPDATE " + tableName + " set  address=?  where student_id=? "
					+ "AND '"+ data +"' > begin_time  AND '"+ data + "'< end_time";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, address);
			pstmt.setString(2, studentId);
			result = pstmt.executeUpdate();
			return result;
		}

		public int selectStage(String date,String studentId) throws SQLException {//查看当前阶段
			Connection conn = DBUtil.getConnection();
			String sql = "SELECT * FROM shixi "
					+ "WHERE'"+ date +"' > begin_time "
					+ "AND '"+ date +"' < end_time "
					+ "AND shixi_id = ( SELECT  shixi_id FROM shixireport "
					+ "WHERE student_Id = ? LIMIT 1)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, studentId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				DBUtil.freeConnection(conn);
				return 1;
			}
			String sql1 = "SELECT * FROM shixun "
					+ "WHERE'"+ date +"' > begin_time "
					+ "AND '"+ date +"' < end_time "
					+ "AND shixi_id = ( SELECT  shixi_id FROM shixireport "
					+ "WHERE student_Id = ? LIMIT 1)";
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, studentId);
			ResultSet rs1 = pstmt1.executeQuery();
			if (rs1.next()) {
				DBUtil.freeConnection(conn);
				return 2;
			}
			String sql2 = "SELECT * FROM shijian "
					+ "WHERE'"+ date +"' > begin_time "
					+ "AND '"+ date +"' < end_time "
					+ "AND shixi_id = ( SELECT  shixi_id FROM shixireport "
					+ "WHERE student_Id = ? LIMIT 1)";
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setString(1, studentId);
			ResultSet rs2 = pstmt2.executeQuery();
			if (rs2.next()) {
				DBUtil.freeConnection(conn);
				return 3;
			}
			else {
				DBUtil.freeConnection(conn);
				return 0;
			}
		}
		
		public String address(String table,String week,String studengId) throws SQLException {//获取下载地址
			Connection conn = DBUtil.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "SELECT address FROM "+table+" WHERE WEEK = "+week+" AND student_id = "+studengId+"";
			
			String address = "";
		    ResultSet set = null;
		    set = stmt.executeQuery(sql);
		    if (!set.next()) return ""; //若未查到直接退出
		    else {
		    address  = set.getString("address");
		    }
		    System.out.println(sql);
		    System.out.println(address);
		    return address;
		}
		
		public studenteditBean listedit(String studentId) throws SQLException {//显示修改前信息
			
			Connection conn = DBUtil.getConnection();
			studenteditBean bean = new studenteditBean();
			String sql = "SELECT * FROM student, student_train  "
					+ "WHERE student_train.student_id = ? "
					+ "AND student.student_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, studentId);
			pstmt.setString(2, studentId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setPhone(rs.getString("student_phone"));
				bean.setQq(rs.getString("student_qq"));
				bean.setCompany(rs.getString("company"));
				bean.setProvince(rs.getString("province"));
				bean.setCity(rs.getString("city"));
				bean.setContactName(rs.getString("contact_name"));
				bean.setContactPhone(rs.getString("contact_phone"));
			}
			return bean;
		}
		
}
		
