package cn.edu.scu.tmooc.entity;

import java.util.Date;

public class Data {
         int id;
		 int dataid;
         int courseid;
         String dataname;
         String datapath;
         //Date datadate;
         public Data() {
 			super();
 			
 		}
         
         public Data(int id, int dataid, int courseid, String dataname,
				String datapath/*, Date datadate*/) {
			super();
			this.id = id;
			this.dataid = dataid;
			this.courseid = courseid;
			this.dataname = dataname;
			this.datapath = datapath;
			//this.datadate = datadate;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getDataid() {
			return dataid;
		}

		public void setDataid(int dataid) {
			this.dataid = dataid;
		}

		public int getCourseid() {
			return courseid;
		}

		public void setCourseid(int courseid) {
			this.courseid = courseid;
		}

		public String getDataname() {
			return dataname;
		}

		public void setDataname(String dataname) {
			this.dataname = dataname;
		}

		public String getDatapath() {
			return datapath;
		}

		public void setDatapath(String datapath) {
			this.datapath = datapath;
		}
/*
		public Date getDatadate() {
			return datadate;
		}

		public void setDatadate(Date datadate) {
			this.datadate = datadate;
		}*/
		
}
