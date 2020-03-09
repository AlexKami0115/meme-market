import { Patron } from './patron';
import { PurchaseLevel } from './purchase-level';

export class Purchase {
    id: number;
    patron: Patron;
    purchaseLevel: PurchaseLevel;
    purchaseDate: Date;
}
