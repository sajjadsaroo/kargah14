import model.User;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("[L]ogin, [S]ign up: ");
        String input = sc.nextLine().trim().toLowerCase();

        if (input.equals("s") || input.equals("sign up")) {
            signUp(sc);
        } else if (input.equals("l") || input.equals("login")) {
            login(sc);
        } else {
            System.out.println("Invalid option.");
        }

        HibernateUtil.getSessionFactory().close();
    }

    private static void signUp(Scanner sc) {
        System.out.print("First Name: ");
        String fn = sc.nextLine();
        System.out.print("Last Name: ");
        String ln = sc.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Password: ");
        String pw = sc.nextLine();

        if (pw.length() < 8) {
            System.out.println("Weak password");
            return;
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            User existing = (User) session.createQuery("FROM User WHERE email = :email")
                    .setParameter("email", email)
                    .uniqueResult();

            if (existing != null) {
                System.out.println("An account with this email already exists");
                tx.rollback();
                return;
            }

            // ثبت‌نام کاربر جدید
            User user = new User(fn, ln, age, email, pw);
            session.save(user);
            tx.commit();
            System.out.println("Signup successful!");
        }
    }

    private static void login(Scanner sc) {
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Password: ");
        String pw = sc.nextLine();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            User user = (User) session.createQuery("FROM User WHERE email = :email AND password = :pw")
                    .setParameter("email", email)
                    .setParameter("pw", pw)
                    .uniqueResult();

            if (user != null) {
                System.out.println("Welcome, " + user.getFullName() + "!");
            } else {
                System.out.println("Invalid email or password");
            }
        }
    }
}
