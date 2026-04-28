import fs from "fs";
import path from "path";

const CREDITS = path.join(process.cwd(), "../common/src/main/resources/assets/somemoreblocks/lang/credits.json");

export class Language {
  /**
   * @type {Language[]}
   */
  static AVAILABLE_LANGUAGES = [];

  /**
   * The language title.
   * @type {string}
   */
  title;

  /**
   * The language code. For example, English (United States) will be "en_us".
   * @type {string}
   */
  code = undefined;

  /**
   * All the people that has contribution to this translation.
   * @type {string[]}
   */
  credits = [];

  /**
   * The credits as string.
   * @type {string}
   */
  stringifiedCredits = undefined;

  /**
   * 
   * @param {string} langCode The language code.
   */
  constructor(langCode) {
    this.code = langCode;
    this.#collectLanguageInfo();

    this.stringifiedCredits = this.#getStringifiedCredits();
  }

  #collectLanguageInfo() {
    const rawData = fs.readFileSync(CREDITS, 'utf-8');

    /**
     * @type {{
     *  [code: string]: {
     *    title: string[],
     *    credits: string[]
     *  }
     * }}
     */
    const data = JSON.parse(rawData);

    this.title = data[this.code].title;
    this.credits = data[this.code].credits;
  }

  #getStringifiedCredits() {
    return this.credits.length > 1 
      ? this.credits.slice(0, -1).join(", ") + " and " + this.credits[this.credits.length - 1] 
      : this.credits[0] ?? "";
  }
}