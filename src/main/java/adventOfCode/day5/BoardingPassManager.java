package adventOfCode.day5;

import java.util.Arrays;

public class BoardingPassManager {

    public int getRow(String pass) {
        int[] rows = fillArrayFromZeroWithStep(1,128);

        for(int i=0; i<7; i++){
            if(pass.charAt(i) == 'F'){
                rows = Arrays.copyOfRange(rows,0,rows.length/2);
            }else{
                rows = Arrays.copyOfRange(rows, rows.length/2, rows.length);
            }
        }

        return rows[0];
    }

    public int getColumn(String pass) {
        int[] columns = fillArrayFromZeroWithStep(1,8);

        for(int i=0; i<3; i++){
            if(pass.charAt(7 + i) == 'L'){
                columns = Arrays.copyOfRange(columns,0,columns.length/2);
            }else{
                columns = Arrays.copyOfRange(columns, columns.length/2, columns.length);
            }
        }
        return columns[0];
    }


    private int[] fillArrayFromZeroWithStep(int step, int size) {
        int[] array = new int[size];
        for(int i = 0; i< size; i = i+step){
            array[i] = i;
        }

        return array;

    }

    public int getSeatId(String pass) {
        return getRow(pass) * 8 + getColumn(pass);
    }
}
