import { MINECRAFT_VERSION } from "../main.mjs";

export class Version {

  /**
   * Check if the current version is the expected one.
   * @param {string} expectedVersion The expected version.
   */
  static isExpectedVersion(expectedVersion) {
    const match = expectedVersion.match(/(>=|<=|==|>|<)?([\d.]+)/);
    
    if (!match) return false;

    let operator = match[1] || "==";
    let targetVersion = match[2];
    let currentVersion = MINECRAFT_VERSION;

    const targetParts = targetVersion.split('.').map(Number);
    const currentParts = currentVersion.split('.').map(Number);

    function compareArrays(arr1, arr2) {
      for (let i = 0; i < Math.max(arr1.length, arr2.length); i++) {
        const num1 = arr1[i] || 0;
        const num2 = arr2[i] || 0;
            
        if (num1 > num2) return 1;
        if (num1 < num2) return -1;
      }
      
      return 0;
    }

    const comparisonResult = compareArrays(currentParts, targetParts);

    const comparisons = {
      "==": (res) => res === 0,
      ">": (res) => res > 0,
      "<": (res) => res < 0,
      ">=": (res) => res >= 0,
      "<=": (res) => res <= 0
    };

    return comparisons[operator](comparisonResult);
  }
}