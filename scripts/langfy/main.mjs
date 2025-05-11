import { CollectLanguages } from './core/CollectLanguages.mjs';

const args = process.argv.slice(2);
export const MINECRAFT_VERSION = args[0];
export const NG_NAME = "Nicolle Gama";
export const MOD_NAME = args[1];

CollectLanguages.collect();
