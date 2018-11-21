package com.github.barismeral.quickio;

import java.io.*;

/**
 * @author Barış Meral
 * @version 1.0
 * @since 20118.11.12
 *
 */
public final class QuickIO {


    private final static String win32DataPath = "C:\\ProgramData\\QuickIO";
    private final static String linuxDataPath = "/usr/sbin/QuickIO";

    private static String osName;
    private  static OperatingSystem oS;


static {
    new QuickIO();
}

    /**
     * private Constructor for operating system info
     * and set Operating system directory
     */
    private QuickIO() {

        osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("windows")){

            oS = new OperatingSystem() {
                public String getName() {
                    return "windows";
                }

                public String getPath() {
                    return win32DataPath;
                }
            };

        }
        else if (osName.contains("linux")) {

            oS = new OperatingSystem() {
                public String getName() {
                    return "linux";
                }

                public String getPath() {
                    return linuxDataPath;
                }
            };

        }


    }


    /**
     *<b>Sets the value of the preference identified by key.</b>
     * @param key data name
     * @param value data value as String
     * @return Key interface key path value
     */
    public static Key setString(final String key, final String value) {

        final File file = new File(oS.getPath());
        if (!file.exists()){
            file.mkdir();
        }

        try {

    File data = new File(file.getPath()+"\\"+key+".data");

            data.createNewFile();
            FileWriter fileWriter = new FileWriter(data);
            fileWriter.write(value);
            fileWriter.close();

            }catch (Exception f){
            f.printStackTrace();
            }

        return new Key() {
            public String getKey() {
                return key;
            }

            public String getPath() {
                return file.getPath();
            }

            public String getValue() {
                return value;
            }
        };
    }


    /**
     *<b>Sets the value of the preference identified by key.</b>
     * @param key data name
     * @param value data value as int
     * @return Key interface key path value
     */
    public static Key setInteger(final String key, final int value) {

        final File file = new File(oS.getPath());
        if (!file.exists()){
            file.mkdir();
        }

        try {

            File data = new File(file.getPath()+"\\"+key+".data");

            data.createNewFile();
            FileWriter fileWriter = new FileWriter(data);
            fileWriter.write(String.valueOf(value));
            fileWriter.close();

        }catch (Exception f){
            f.printStackTrace();
        }

        return new Key() {
            public String getKey() {
                return key;
            }

            public String getPath() {
                return file.getPath();
            }

            public Integer getValue() {
                return value;
            }
        };
    }


    /**
     * <b>Sets the value of the preference identified by key.</b>
     * @param key data name
     * @param value data value as double
     * @return Key interface key path value
     */
    public static Key setDouble(final String key, final double value) {

        final File file = new File(oS.getPath());
        if (!file.exists()){
            file.mkdir();
        }

        try {

            File data = new File(file.getPath()+"\\"+key+".data");

            data.createNewFile();
            FileWriter fileWriter = new FileWriter(data);
            fileWriter.write(String.valueOf(value));
            fileWriter.close();

        }catch (Exception f){
            f.printStackTrace();
        }

        return new Key() {
            public String getKey() {
                return key;
            }

            public String getPath() {
                return file.getPath();
            }

            public Double getValue() {
                return value;
            }
        };
    }
    /**
     * <b>Sets the value of the preference identified by key.</b>
     * @param key data name
     * @param value data value as boolean
     * @return Key interface key path value
     */
    public static Key setBoolean(final String key, final boolean value) {

        final File file = new File(oS.getPath());
        if (!file.exists()){
            file.mkdir();
        }

        try {

            File data = new File(file.getPath()+"\\"+key+".data");

            data.createNewFile();
            FileWriter fileWriter = new FileWriter(data);
            fileWriter.write(String.valueOf(value));
            fileWriter.close();

        }catch (Exception f){
            f.printStackTrace();
        }

        return new Key() {
            public String getKey() {
                return key;
            }

            public String getPath() {
                return file.getPath();
            }

            public Boolean getValue() {
                return value;
            }
        };
    }

    /**
     * <b>Sets the value of the preference identified by key.</b>
     * @param key data name
     * @param value data value as char
     * @return Key interface key path value
     */
    public static Key setCharacter(final String key, final char value) {


        final File file = new File(oS.getPath());
        if (!file.exists()){
            file.mkdir();
        }

        try {

            File data = new File(file.getPath()+"\\"+key+".data");

            data.createNewFile();
            FileWriter fileWriter = new FileWriter(data);
            fileWriter.write(value);
            fileWriter.close();

        }catch (Exception f){
            f.printStackTrace();
        }

        return new Key() {
            public String getKey() {
                return key;
            }

            public String getPath() {
                return file.getPath();
            }

            public Character getValue() {
                return value;
            }
        };
    }


    /**
     * Returns the value corresponding to key in the preference file if it exists.
     * @param key as data name
     * @return value string
     */
    public static String getString(String key){

    String val=null;
    try {
        FileReader fileReader = new FileReader(oS.getPath()+"\\"+key+".data");

        BufferedReader bufferedReader = new BufferedReader(fileReader);

       val = bufferedReader.readLine();

    }catch (FileNotFoundException f){
        f.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }


        return val;
    }

    /**
     * Returns the value corresponding to key in the preference file if it exists.
     * @param key as data name
     * @return value int
     */
    public static int getInteger(String key){

        int val=0;
        try {
            FileReader fileReader = new FileReader(oS.getPath()+"\\"+key+".data");

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            val = Integer.parseInt(bufferedReader.readLine());

        }catch (FileNotFoundException f){
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException n){
            n.printStackTrace();
        }


        return val;
    }
    /**
     * Returns the value corresponding to key in the preference file if it exists.
     * @param key as data name
     * @return value boolean
     */
    public static boolean getBoolean(String key){

        boolean val=false;
        try {
            FileReader fileReader = new FileReader(oS.getPath()+"\\"+key+".data");

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            val = Boolean.valueOf(bufferedReader.readLine());

        }catch (FileNotFoundException f){
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        return val;
    }
    /**
     * Returns the value corresponding to key in the preference file if it exists.
     * @param key as data name
     * @return value double
     */
    public static double getDouble(String key){

       double val=0.0d;
        try {
            FileReader fileReader = new FileReader(oS.getPath()+"\\"+key+".data");

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            val = Double.valueOf(bufferedReader.readLine());

        }catch (FileNotFoundException f){
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException n){
            n.printStackTrace();
        }


        return val;
    }

    /**
     * Returns the value corresponding to key in the preference file if it exists.
     * @param key as data name
     * @return value char
     */
    public static char getCharacter(String key){

        char val='\0';
        try {
            FileReader fileReader = new FileReader(oS.getPath()+"\\"+key+".data");

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            val = (char)fileReader.read();

        }catch (FileNotFoundException f){
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return val;
    }

    /**
     * <b>Removes all keys and values from the preferences. Use with caution.</b>
     * @return int deleted data count
     */
    public static int deleteAll(){

    File file = new File(oS.getPath());
    File[] files = file.listFiles();


    for (File f : files){

        f.delete();
    }

    return files.length;
    }

    /**
     * <b>Removes key and its corresponding value from the preferences.</b>
     * @param key for will be deleted
     */
   public static void deleteKey(String key){

    File file = new File(oS.getPath()+"\\"+key+".data");
    file.delete();

   }

    /**
     *
     * @param key for searching data
     * @return boolean Returns true if key exists in the preferences.
     *
     */
   public static boolean hasKey(String key){

    return  new File(oS.getPath()+"\\"+key+".data").exists();

   }


    /**
     *
     * @return String[] key names
     */
   public static String[] allKeys(){

    File file = new File(oS.getPath());

    String array[] = file.list();

    int i = 0;

        for (String s : file.list()){
            array[i] = s.substring(0,s.length()-5);
            i++;
        }
     return array;

   }

}
