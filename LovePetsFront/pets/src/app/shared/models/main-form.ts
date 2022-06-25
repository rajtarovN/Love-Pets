export interface MainForm {
  activeness: boolean;
  levelOfProtection: number;
  hoursPerWeek: number;
  price: number;
  placeForLiving: string;
  type?: string;

  liveWith: string[];
  alergic: string[];
  afraidOf: string[];
}
