import { CollectLanguages } from './core/CollectLanguages.mjs';

const args = process.argv.slice(2);
export const MINECRAFT_VERSION = args[0];
export const NG_NAME = "Nicolle Gama"; // ★ October 30, 2001 - ✟ February 13, 2024
export const MOD_NAME = args[1];

CollectLanguages.collect();
