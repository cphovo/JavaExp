package demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fortune {

    private static final SecureRandom RANDOM = new SecureRandom();
    private final ArrayList<String> fortunes = new ArrayList<>();

    public Fortune() throws JsonProcessingException {
        // 读取 fortunes.json 文件并解析，保存到 fortunes 列表中
        String json = readInputStream(ClassLoader.getSystemResourceAsStream("fortunes.json"));
        ObjectMapper omap = new ObjectMapper();
        JsonNode root = omap.readTree(json);
        JsonNode data = root.get("data");
        Iterator<JsonNode> elements = data.elements();
        while (elements.hasNext()) {
            JsonNode next = elements.next();
            JsonNode quote = next.get("quote");
            JsonNode author = next.get("author");
            fortunes.add(quote.asText() + "\t-- " + author.asText());
        }
    }

    private String readInputStream(InputStream is) {
        StringBuilder out = new StringBuilder();
        try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }

        } catch (IOException e) {
            Logger.getLogger(Fortune.class.getName()).log(Level.SEVERE, null, e);
        }
        return out.toString();
    }

    private void printRandomFortune() throws InterruptedException {
        // 随机取出一条 quote 进行打印
        int r = RANDOM.nextInt(fortunes.size());
        String f = fortunes.get(r);
        for (char c : f.toCharArray()) {
            System.out.print(c);
            Thread.sleep(100);
        }
        System.out.println();
    }

    public static void main(String[] args) throws InterruptedException, JsonProcessingException {
        Fortune fortune = new Fortune();
        fortune.printRandomFortune();
    }
}