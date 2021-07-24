package ua.com.alevel;

import ua.com.alevel.crud.impl.UserDao;

public class AboutAllOperationsMain {

    public static void main(String[] args) {
        System.out.println("AboutAllOperationsMain.main");
        UserDao userDao = new UserDao();
        userDao.test();
//        User user1 = new User();
//        User user2 = new User();
//
//        user1.setAge(10);
//        user1.setName("AB");
//        user1.setInn(100);
//
//        user2.setAge(10);
//        user2.setName("A");
//        user2.setInn(100);
//
//        boolean eq = user1.equals(user2);
//        System.out.println("eq = " + eq);
//
//        AbstractService abstractService = new AbstractService();
//        abstractService.create(new User());
//        abstractService.create(new Admin());
//        abstractService.create(new Personal());
//
//        User user = (User) abstractService.getById(9L);
    }
}
