package java0520;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

abstract class Player {
    private String name;
    private String initNumber;
    private List<String> fightList = new LinkedList<>();
    private Boolean isEnd;

    public Player(String name, String initNumber) {
        this.name = name;
        this.initNumber = initNumber;
        this.isEnd = false;
    }

    public abstract void play(String number) throws Exception;

    public Boolean getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(Boolean isEnd) {
        this.isEnd = isEnd;
    }

    public String getInitNumber() {
        return initNumber;
    }

    public String getName() {
        return name;
    }

    public void printFightList() {
        System.out.println("ATeam");
        //System.out.println("Strike : " + strike + ", Ball :" + ball + ", Out: " + out);
        System.out.println("----------------------------------------");
        System.out.println("Bteam");
        System.out.println("----------------------------------------");
    }
}

class PlayerATeam extends Player {
    public PlayerATeam(String name, String number) {
        super(name, number);
    }

    @Override
    public void play(String number) throws Exception {
        int strike = 0;
        int ball = 0;
        int out = 0;

        //정답 숫자
        String answers = getInitNumber();

        //입력받은 숫자를 저장 할 배열 생성
        char[] numbers = new char[4];

        //입력 받은 값을 배열에 저장
        for (int i = 0; i < 4; i++) {
            numbers[i] = number.charAt(i);
        }

        //입력 받은 값을 A팀의 정답과 비교
        for (int i = 0; i < 4; i++) {
            if (answers.charAt(i) == numbers[i]) {
                strike++;
            } else if (answers.contains(String.valueOf(numbers[i]))) {
                ball++;
            } else {
                out++;
            }
        }

        if (strike == 4) {
            System.out.println("Congratulation!");
            super.setIsEnd(true);
        } else {
            System.out.println("Strike : " + strike + ", Ball :" + ball + ", Out: " + out);
        }
    }
}

class PlayerBTeam extends Player {
    public PlayerBTeam(String name, String number) {
        super(name, number);
    }

    @Override
    public void play(String number) throws Exception {
        int strike = 0;
        int ball = 0;
        int out = 0;

        //정답 숫자
        String answers = getInitNumber();

        //입력받은 숫자를 저장 할 배열 생성
        char[] numbers = new char[4];

        //입력 받은 값을 배열에 저장
        for (int i = 0; i < 4; i++) {
            numbers[i] = number.charAt(i);
        }

        //입력 받은 값을 B팀의 정답과 비교
        for (int i = 0; i < 4; i++) {
            if (answers.charAt(i) == numbers[i]) {
                ball++;
            } else if (answers.contains(String.valueOf(numbers[i]))) {
                strike++;
            } else {
                out++;
            }
        }

        if (ball == 4) {
            System.out.println("Congratulation!");
            super.setIsEnd(true);
        } else {
            System.out.println("Strike : " + strike + ", Ball :" + ball + ", Out: " + out);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player playerArray[] = {new PlayerATeam("A Team", "1234"), new PlayerBTeam("B Team", "5678")};
        int checkPlayer = 0;

        while (true) {
            checkPlayer = 0;
            for (Player player : playerArray) {
                if (player.getIsEnd() == false) {
                    System.out.print("Please enter a 4 digit number (" + player.getName() + ") defence : ");
                    String number = scanner.nextLine();
                    try {
                        player.play(number);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    checkPlayer++;
                }
            }
            if (checkPlayer == playerArray.length) break;
        }

        for (Player player : playerArray) {
            player.printFightList();
        }
    }
}
