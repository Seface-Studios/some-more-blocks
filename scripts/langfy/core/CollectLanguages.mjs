import fs from "fs";
import path from "path";
import { Language } from "./Language.mjs";
import { Version } from "./Version.mjs";
import { MOD_NAME, NG_NAME } from "../main.mjs";

const EXCLUDED_JSON_FILES = ["credits.json", "deprecated_strings.json"];
const LANG_DIR = path.join(process.cwd(), "../common/src/main/resources/assets/somemoreblocks/lang");

const DEPRECATED_STRINGS = path.join(LANG_DIR, "deprecated_strings.json");
const LANG_OUTPUT_DIR = path.join(process.cwd(), "../common/src/main/generated/assets/somemoreblocks/lang");

export class CollectLanguages {
  static collect() {
    if (!fs.existsSync(LANG_OUTPUT_DIR)) {
      fs.mkdirSync(LANG_OUTPUT_DIR, { recursive: true });
    }

    const langDirs = fs.readdirSync(LANG_DIR).filter(file => {
      return fs.statSync(path.join(LANG_DIR, file)).isDirectory();
    });

    langDirs.forEach(langCode => {
      const language = new Language(langCode);

      if (langCode !== "en_us") {
        console.log(`${language.title} translation by:`, language.stringifiedCredits);
      }

      const langPath = path.join(LANG_DIR, langCode);
      const jsonFiles = fs.readdirSync(langPath)
        .filter(file => file.endsWith('.json') && !EXCLUDED_JSON_FILES.includes(file));

      let mergedData = {};

      jsonFiles.forEach(jsonFile => {
        const filePath = path.join(langPath, jsonFile);
        const rawFileData = fs.readFileSync(filePath, 'utf-8')
          .replaceAll("${mod_name}", MOD_NAME)
          .replaceAll("${ng_name}", NG_NAME);

        const fileData = JSON.parse(rawFileData);
        Object.assign(mergedData, fileData);
      });

      const deprecatedStringsData = JSON.parse(fs.readFileSync(DEPRECATED_STRINGS, 'utf-8'));

      // Remove all deprecated strings
      for (const deprecatedVersion of Object.keys(deprecatedStringsData['removed'])) {
        if (!Version.isExpectedVersion(deprecatedVersion)) continue;

        const keys = deprecatedStringsData['removed'][deprecatedVersion];
        for (const key of keys) {
          if (mergedData.hasOwnProperty(key)) {
            delete mergedData[key];
          }
        }
      }

      const outputPath = path.join(LANG_OUTPUT_DIR, `${langCode}.json`);
      fs.writeFileSync(outputPath, Buffer.from(JSON.stringify(mergedData)));
    });
  }
}