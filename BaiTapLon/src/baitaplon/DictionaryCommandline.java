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
public class DictionaryCommandline {
    public DictionaryManagement dicmngm = new DictionaryManagement();
    
     public void showMenu(){
        System.out.println();
        System.out.println("****************Dictionary****************");
        System.out.println("1. Thêm từ");
        System.out.println("2. Tra từ");
        System.out.println("3. Xóa từ");
        System.out.println("4. Sửa từ");
        System.out.println("5. Hiện tất cả các từ");
        System.out.print("Lựa chọn của bạn : ");
        dicmngm.dictionarySetlection();
        this.showMenu();
    }
    public void dictionaryAdvanced() {
       dicmngm.insertFromFile();
       
       this.showMenu();
    }
}
