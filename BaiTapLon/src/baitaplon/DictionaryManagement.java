/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitaplon;

/**
 *
 * @author lochoi
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class DictionaryManagement{

//    private static final Scanner sc = new Scanner(System.in);

//    public void insertFromCommandline(){
//        System.out.println("Nhap vao so tu: ");
//        numWord = Integer.parseInt(sc.nextLine());
//        Word nw = new Word();
//        for (int i= 0; i < numWord; i++){
//            System.out.println("Nhap vao tu moi: ");
//            nw.word_target = sc.nextLine();
//            System.out.println("Nhap vao nghia:");
//            nw.word_explain = sc.nextLine();
//            word_target[i] = nw.word_target;
//            word_explain[i] = nw.word_explain;
//        }

 //   }

//    public void insertFromFile(){
//        File file = new File("C:\\Users\\locho\\OneDrive\\Desktop\\BaiTapLon\\src\\baitaplon\\test.txt");
//        try(Scanner scan = new Scanner(file)) {
//            int i = 0;
//            while(scan.hasNext()){
//                word_target[i] = scan.next();
//                word_explain[i] = scan.nextLine();
//                i++;
//            }
//            numWord = i;
//        } catch (Exception e) {
//        }
//    }
//
//    public void dictionaryLookup(){
//        String keyWord;
//        System.out.println("Nhap tu can tra: ");
//        keyWord = sc.next().toLowerCase();
//        for(int i = 0; i < 5; i++){
//            if(word_target[i].equals(keyWord)){
//                System.out.println("Nghia: " + word_explain[i]);
//                break;
//            }
//        }
//    }
//
//    // hàm tìm kiếm
//        public String dictionarySearcher(Word){
//        for(Word elementWord: Dictionary.list_word){
//            if((elementWord.getWord_target().substring(0,ds.length())).equals(word)){
//                return elementWord.word_explain;
//            }
//        }
//    }
//    public static void main(String[] args){
//        DictionaryCommandline run = new DictionaryCommandline();
//       // run.dictionaryBasic();
//        run.dictionaryAdvanced();
//    }

    private Dictionary sach = new Dictionary();
    public Dictionary getDictionary(){
        return sach;
    }
    public void setDictionary(Dictionary sach){
        this.sach = sach;
    }

    public void dictionarySetlection(){
        Scanner choose = new Scanner(System.in);

        int numOfSet = choose.nextInt();

        switch(numOfSet){
            case 1:
                this.insertWord();
                break;
            case 2:
                this.dictionarySearcher();
                break;
            case 3:
                this.deleteWord();
                break;
            case 4:
                this.fixWord();
                break;
            case 5:
                this.showAllWords();
                break;
            default:
                System.out.println("Error!");
                break;
        }
    }
    public void insertFromFile(){
        File file = new File("D:\\BaiTapLon\\src\\baitaplon\\tuDien.txt");
        try(Scanner sc = new Scanner(file)) {
            String wordTarget, wordExplain;
            while(sc.hasNextLine()){
                String oneLine = sc.nextLine();
                wordTarget = oneLine.substring(0, oneLine.indexOf("\t"));
                wordExplain = oneLine.substring(oneLine.indexOf("\t")+1);

                Word word = new Word();
                word.setWord_target(wordTarget);
                word.setWord_explain(wordExplain);
                this.getDictionary().getWord().add(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file.");
        }
    }
    // chen them tu
    public void insertWord(){
        Word wordInsert = new Word();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập từ cần thêm: ");
        wordInsert.setWord_target(sc.nextLine());
        System.out.println("Nhập nghĩa: ");
        wordInsert.setWord_explain(sc.nextLine());

        boolean checkInsert = true;

        for(Word word: this.getDictionary().getWord()){
            if(word.getWord_target().equals(wordInsert.getWord_target())){
                checkInsert = false;
                System.out.println("Từ có sãn, thêm không thành công.");
                break;
            }
        }
        if(checkInsert){
            sach.getWord().add(wordInsert);
            System.out.println("Thêm từ thành công.");
        }
    }
    // tìm kiếm từ
    public void dictionarySearcher(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập từ cần dịch");
        String keyWord = sc.nextLine();
        boolean check = false;
        int num = 0;
        System.out.println("No|\t English \t| Vietnamese \t\t");
        for(Word word : this.getDictionary().getWord()){
            if(word.getWord_target().contains(keyWord) && word.getWord_target().indexOf(keyWord) == 0){
                num++;
                check = true;
                System.out.println(num + "| \t" + word.getWord_target() + "\t\t| " + word.getWord_explain() + "\t\t");
            }
        }
        if(!check)
            System.out.println("Không có từ cần tìm.");
    }
    //xóa từ
    public void deleteWord(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Từ cần xóa: ");
        String delWord = sc.nextLine();
        boolean checkDel = false;
        
        for(Word word: this.getDictionary().getWord()){
            if(word.getWord_target().equals(delWord)){
                this.getDictionary().getWord().remove(word);
                checkDel = true;
                System.out.println("Xóa từ thành công");
                break;
            }
        }
        if(!checkDel)
            System.out.println("Không tìm thấy từ cần xóa.");
    }
    //sửa từ
    public void fixWord(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Sửa từ");
        System.out.println("2. Sửa nghĩa");
        System.out.println("Lựa chọn: ");
        int choo = sc.nextInt();
        switch(choo){
            case 1:
                System.out.println("Nhập từ cần sửa: ");
                String wordFix1;
                wordFix1= sc.nextLine().toLowerCase();
                for(Word word: this.getDictionary().getWord()){
                    if(word.getWord_target().equals(wordFix1)){
                        System.out.println("Sửa thành: ");
                        String wordReplace = sc.nextLine();
                        word.setWord_target(wordReplace);
                        break;
                    }
                }
            case 2:
                System.out.println("Nhập từ cần sửa: ");
                String wordFix2;
                wordFix2= sc.nextLine().toLowerCase();
                for(Word word: this.getDictionary().getWord()){
                    if(word.getWord_explain().equals(wordFix2)){
                        System.out.println("Sửa thành: ");
                        String wordReplace = sc.nextLine();
                        word.setWord_explain(wordReplace);
                        break;
                    }
                }
            default:
                System.out.println("Error");
                break;
        }
    }
    //in ra ngoai man hinh
    public void showAllWords(){
        System.out.println("No|\t English \t| Vietnamese \t\t");
        int num = 1;
        for(Word word: this.getDictionary().getWord()){
            System.out.println(num + "|\t" + word.getWord_target() + "\t| " + word.getWord_explain());
            num++;
        }
    }

    private Object oneLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
