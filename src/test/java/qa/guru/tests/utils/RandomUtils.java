package qa.guru.tests.utils;

public class RandomUtils {

    public String randomElement(String[] subject) {
        int n = (int) Math.floor(Math.random() * subject.length);
        return subject[n];
    }

    public String getRandomGender() {
        String[] genders = new String[]{"Male", "Female", "Other"};
        return randomElement(genders);
    }

    public String getRandomMonth() {
        String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};
        return randomElement(months);
    }

    public String getRandomSubject() {
        String[] subjects = new String[]{"Maths", "Chemistry", "Computer Science",
                "Accounting", "Arts", "Social Studies", "History"};
        return randomElement(subjects);
    }

    public String getRandomHobby() {
        String[] hobbies = new String[]{"Sports", "Reading", "Music"};
        return randomElement(hobbies);
    }


    public String getRandomPicture() {
        String[] pictures = new String[]{"BryfenCP_TMA_distr_1_0.jpg", "BryfenCP_TMA_usual_1_1.jpg", "KNPP1020.970.jpg"};
        return randomElement(pictures);
    }
}