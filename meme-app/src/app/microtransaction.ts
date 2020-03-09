import { Patron } from './patron';
import { PackTier } from './pack-tier';

export class Microtransaction {
    id: number;
    patron: Patron;
    packTier: PackTier;
    transDate: Date;
}
