package com.TaehyunDev;

import com.TaehyunDev.Guitar.*;

import java.util.List;
import java.util.Scanner;

public class GuitarPro {

    private static Inventory GuitarInventory = new Inventory();
    private FileHandler fileHandler = new FileHandler();

    private void searchGuitar() {
        GuitarSpec tempGuitar = null;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n[검색 마법사]\n문자 항목 미기입시는 'n'을 입력하십시오.\n숫자 항목 미기입시는 -1을 입력하십시오.\n\n제조사를 입력하삽시오(Fender, Yamaha, Samsung):");
            String tempBuilder = scanner.nextLine();
            System.out.println("모델명을 입력하십시오:");
            String tempModel = scanner.next();
            System.out.println("종류를 입력하십시오(Acoustic, Electric, Classic):");
            String tempType = scanner.next();
            System.out.print("줄 갯수를 입력하십시오(미 기입시는 -1): ");
            Integer tempStrings = scanner.nextInt();
            System.out.println("뒷면을 입력하십시오(Alder, Base):");
            String tempBack = scanner.next();
            System.out.println("앞면을 입력하십시오(Alder, Base):");
            String tempFront = scanner.next();
            tempGuitar =
                    new GuitarSpec(Builder.valueOf(tempBuilder.toUpperCase()), tempModel,
                            Type.valueOf(tempType.toUpperCase()), tempStrings, Wood.valueOf(tempBack.toUpperCase()), Wood.valueOf(tempFront.toUpperCase()));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n\n입력 에러 입니다.\n\n");
            searchGuitar();
        }

        if(tempGuitar == null){
            System.out.println("중대에러!");
            System.exit(1);
        }

        List<Guitar> matchingGuitars = GuitarInventory.search(tempGuitar);

        if (!matchingGuitars.isEmpty()) {
            System.out.println("[검색결과]");
            int tempCount = 0;
            for (Guitar guitar : matchingGuitars) {
                tempCount++;
                GuitarSpec spec = guitar.getSpec();
                System.out.println("[" +tempCount+"] "+ spec.getModel()+"\n"+
                        "제조사: "+spec.getBuilder()+"\n"+
                        "종류: "+spec.getType()+"\n"+
                        "뒷면: "+spec.getBackWood()+"\n"+
                        "윗면: "+spec.getTopWood()+"\n"+
                        "가격: "+guitar.getPrice() + "\n---------------");
            }
            System.out.println("\n총 "+tempCount+"개의 검색 결과가 있습니다.");
        }else{
            System.out.println("검색 결과가 없습니다.");
        }
        searchGuitar();

    }

    private void registerGuitar(){
        GuitarSpec tempGuitar = null;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n[기타 추가 마법사]\n\n제조사를 입력하삽시오(Fender, Yamaha, Samsung):");
            String tempBuilder = scanner.nextLine();
            System.out.println("모델명을 입력하십시오:");
            String tempModel = scanner.next();
            System.out.println("종류를 입력하십시오(Acoustic, Electric, Classic):");
            String tempType = scanner.next();
            System.out.print("줄 갯수를 입력하십시오: ");
            Integer tempStrings = scanner.nextInt();
            System.out.println("뒷면을 입력하십시오(Alder, Base):");
            String tempBack = scanner.next();
            System.out.println("앞면을 입력하십시오(Alder, Base):");
            String tempFront = scanner.next();
            System.out.print("가격을 입력하십시오: ");
            Integer tempPrice = scanner.nextInt();
            tempGuitar =
                    new GuitarSpec(Builder.valueOf(tempBuilder.toUpperCase()), tempModel,
                            Type.valueOf(tempType.toUpperCase()), tempStrings, Wood.valueOf(tempBack.toUpperCase()), Wood.valueOf(tempFront.toUpperCase()));
            GuitarInventory.addGuitar(tempModel, tempPrice, tempGuitar);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n\n입력 에러 입니다.\n\n");
            searchGuitar();
        }
        System.out.println("\n기타가 추가되었습니다.");
        saveGuitarData();
    }

    private void addDummyData() {
        GuitarInventory.addGuitar("11277", 3285.33,
                new GuitarSpec(Builder.FENDER, "TH-1", Type.CLASSIC, 6,
                        Wood.ALDER, Wood.BASE));
        GuitarInventory.addGuitar("V95693", 1567.9,
                new GuitarSpec(Builder.FENDER, "TH-2", Type.ELECTRIC, 8,
                        Wood.ALDER, Wood.ALDER));
        GuitarInventory.addGuitar("V9512", 1782,
                new GuitarSpec(Builder.YAMAHA, "TH-3", Type.ELECTRIC, 6,
                        Wood.ALDER, Wood.ALDER));
        GuitarInventory.addGuitar("122784", 8982.57,
                new GuitarSpec(Builder.YAMAHA, "TH-4", Type.ACOUSTIC, 12,
                        Wood.ALDER, Wood.BASE));
        GuitarInventory.addGuitar("76531", 7749.6,
                new GuitarSpec(Builder.SAMSUNG, "TH-5", Type.CLASSIC, 6,
                        Wood.BASE, Wood.BASE));
        GuitarInventory.addGuitar("70108276", 3254.3,
                new GuitarSpec(Builder.SAMSUNG, "Th-6", Type.ACOUSTIC, 10,
                        Wood.BASE, Wood.ALDER));
    }

    private void loadGuitarData(){
        GuitarInventory.setData(fileHandler.loadData());
    }

    private void saveGuitarData(){
        fileHandler.saveData(GuitarInventory.getGuitarData());
    }

    private void showMenu(){
        System.out.println("[기타 시스템 메뉴]\n[1] 기타 추가\n[2] 기타 검색");
        Scanner scanner = new Scanner(System.in);
        int tempInput = 0;
        try{
            tempInput = scanner.nextInt();
        }catch (Exception e){
            System.out.println("입력에러! 다시 시도하십시오.\n");
            showMenu();
        }
        switch(tempInput){
            case 1:
                registerGuitar();
                break;
            case 2:
                searchGuitar();
                break;
            default:
                System.out.println("입력에러!");
                System.exit(1);
        }
    }


    public static void main(String[] args) {
        GuitarPro guitarPro = new GuitarPro();
        guitarPro.loadGuitarData();
        guitarPro.showMenu();
    }

}
