package org.pc.util.generics;

    public final class Student extends Person {
        String college;
        String grade;
        int rollNo;

        public Student(String name,int age,String college, String grade, int rollNo) {
            super(name,age,"Student");
            this.college = college;
            this.grade = grade;
            this.rollNo = rollNo;
        }

        public String getCollege() {
            return college;
        }

        public void setCollege(String college) {
            this.college = college;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public int getRollNo() {
            return rollNo;
        }

        public void setRollNo(int rollNo) {
            this.rollNo = rollNo;
        }
    }
