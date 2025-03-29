package org.example.ukol1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ukol1 {

    private String htmlSoubor;
    private String outputHtmlSouborName;
    private String outputCssSouborName;

    public Ukol1(String htmlSoubor, String outputHtmlSoubor, String outputCssSoubor) {
        this.htmlSoubor = htmlSoubor;
        this.outputHtmlSouborName = outputHtmlSoubor;
        this.outputCssSouborName = outputCssSoubor;
    }

    public void cleanHtml() throws IOException {
        try (Stream<String> lines = Files.lines(Path.of(this.htmlSoubor))) {
            final StringBuilder contents = new StringBuilder();
            lines.forEach(contents::append);

            String html = contents.toString();

            // 1. Odstranit nepárové tagy
            String neparoveRv = "<\\s*(area|base|br|col|embed|hr|img|input|link|meta|source|track|wbr)(\\s+[^>]*)?\\s*/?>";
            html = html.replaceAll(neparoveRv, "");

            // 2. Vyjmout obsah mezi <body> a </body>
            Matcher bodyMatcher = Pattern.compile("(?is)<body[^>]*>(.*?)</body>").matcher(html);
            String bodyContent = "";
            if (bodyMatcher.find()) {
                bodyContent = bodyMatcher.group(1);
            }

            // 3. Nahradit inline style classou, styl přesunout do CSS
            Map<String, String> styleToClassMap = new HashMap<>();
            int classCounter = 1;

            Pattern tagWithStyle = Pattern.compile("(<(\\w+)([^>]*?)\\sstyle\\s*=\\s*\"(.*?)\"([^>]*)>)", Pattern.CASE_INSENSITIVE);
            Matcher matcher = tagWithStyle.matcher(bodyContent);
            StringBuffer sb = new StringBuffer();

            while (matcher.find()) {
                String tagName = matcher.group(2);
                String preAttrs = matcher.group(3);
                String style = matcher.group(4).trim();
                String postAttrs = matcher.group(5);

                String className = styleToClassMap.get(style);
                if (className == null) {
                    className = "cls" + classCounter++;
                    styleToClassMap.put(style, className);
                }

                // Nahradit style atribut za class
                String newTag = "<" + tagName + preAttrs + " class=\"" + className + "\"" + postAttrs + ">";
                matcher.appendReplacement(sb, Matcher.quoteReplacement(newTag));
            }
            matcher.appendTail(sb);
            bodyContent = sb.toString();

            // 4. Vytvořit novou jednoduchou hlavičku s odkazem na CSS
            String newHead = "<head>\n" +
                    "  <meta charset=\"UTF-8\">\n" +
                    "  <title>Vyčištěná stránka</title>\n" +
                    "  <link rel=\"stylesheet\" href=\"" + this.outputCssSouborName + "\">\n" +
                    "</head>\n";

            String newHtml = "<html>\n" + newHead + "<body>\n" + bodyContent + "\n</body>\n</html>";

            // 5. Zapsat výstupní HTML
            Files.writeString(Path.of(this.outputHtmlSouborName), newHtml);

            // 6. Zapsat CSS
            StringBuilder cssBuilder = new StringBuilder();
            for (Map.Entry<String, String> entry : styleToClassMap.entrySet()) {
                cssBuilder.append(".").append(entry.getValue()).append(" {\n")
                        .append("  ").append(entry.getKey()).append(";\n")
                        .append("}\n");
            }

            Files.writeString(Path.of(this.outputCssSouborName), cssBuilder.toString());
        }
    }
}
