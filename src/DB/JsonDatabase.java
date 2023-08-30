package DB;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

import App.Mobil;
import App.Motor;

public class JsonDatabase {
    private static final String DB_MOBIL = "dataMobil.json";
    private static final String DB_MOTOR = "dataMotor.json";

    public static void writeDataMobil(List<Mobil> data) {
        JsonArray jsonArray = new JsonArray();
        try (BufferedReader reader = new BufferedReader(new FileReader(DB_MOBIL))) {
            String line = reader.readLine();
            if (line != null) {
                JsonArray existingArray = Json.parse(line).asArray();
                for (JsonValue jsonValue : existingArray) {
                    jsonArray.add(jsonValue);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Mobil mobil : data) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("jenis", mobil.getJenis());
            jsonObject.add("brand", mobil.getBrand());
            jsonObject.add("plat", mobil.getPlat());
            jsonObject.add("datang", mobil.getWaktuDatang());
            jsonObject.add("pergi", mobil.getWaktuKeluar());
            jsonObject.add("status", mobil.getMasihParkir());

            jsonArray.add(jsonObject);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DB_MOBIL))) {
            writer.write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Mobil> readDataMobil() {
        List<Mobil> loadedMobilList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(DB_MOBIL))) {
            String jsonString = reader.readLine();

            for (JsonValue jsonValue : Json.parse(jsonString).asArray()) {
                JsonObject jsonObject = jsonValue.asObject();
                String jenis = jsonObject.getString("jenis", "");
                String brand = jsonObject.getString("brand", "");
                String plat = jsonObject.getString("plat", "");
                String datang = jsonObject.getString("datang", "");
                String pergi = jsonObject.getString("pergi", "");
                boolean status = jsonObject.getBoolean("status", false);

                Mobil mobil = new Mobil(brand, jenis, plat, datang, pergi, status);
                loadedMobilList.add(mobil);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return loadedMobilList;
    }

    public static void updateDataMobil(List<Mobil> data) {
        JsonArray jsonArray = new JsonArray();

        for (Mobil mobil : data) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("jenis", mobil.getJenis());
            jsonObject.add("brand", mobil.getBrand());
            jsonObject.add("plat", mobil.getPlat());
            jsonObject.add("datang", mobil.getWaktuDatang());
            jsonObject.add("pergi", mobil.getWaktuKeluar());
            jsonObject.add("status", mobil.getMasihParkir());

            jsonArray.add(jsonObject);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DB_MOBIL))) {
            writer.write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDataMotor(List<Motor> data) {
        JsonArray jsonArray = new JsonArray();

        try (BufferedReader reader = new BufferedReader(new FileReader(DB_MOTOR))) {
            String line = reader.readLine();
            if (line != null) {
                JsonArray existingArray = Json.parse(line).asArray();
                for (JsonValue jsonValue : existingArray) {
                    jsonArray.add(jsonValue);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Motor motor : data) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("jenis", motor.getJenis());
            jsonObject.add("brand", motor.getBrand());
            jsonObject.add("plat", motor.getPlat());
            jsonObject.add("datang", motor.getWaktuDatang());
            jsonObject.add("pergi", motor.getWaktuKeluar());
            jsonObject.add("status", motor.getMasihParkir());

            jsonArray.add(jsonObject);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DB_MOTOR))) {
            writer.write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Motor> readDataMotor() {
        List<Motor> loadedMotorList = new ArrayList<>();
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get(DB_MOTOR)));
            JsonArray jsonArray = Json.parse(jsonString).asArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = jsonArray.get(i).asObject();
                String jenis = jsonObject.get("jenis").asString();
                String brand = jsonObject.get("brand").asString();
                String plat = jsonObject.get("plat").asString();
                String datang = jsonObject.get("datang").asString();
                String pergi = jsonObject.get("pergi").asString();
                boolean status = jsonObject.get("status").asBoolean();
                loadedMotorList.add(new Motor(brand, jenis, plat, datang, pergi, status));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedMotorList;
    }

    public static void updateDataMotor(List<Motor> data) {
        JsonArray jsonArray = new JsonArray();

        for (Motor motor : data) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("jenis", motor.getJenis());
            jsonObject.add("brand", motor.getBrand());
            jsonObject.add("plat", motor.getPlat());
            jsonObject.add("datang", motor.getWaktuDatang());
            jsonObject.add("pergi", motor.getWaktuKeluar());
            jsonObject.add("status", motor.getMasihParkir());

            jsonArray.add(jsonObject);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DB_MOTOR))) {
            writer.write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}