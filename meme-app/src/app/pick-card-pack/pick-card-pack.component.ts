import { Component, OnInit } from '@angular/core';
import { PackService } from '../services/pack.service';
import { Card } from '../card';

@Component({
  selector: 'app-pick-card-pack',
  templateUrl: './pick-card-pack.component.html',
  styleUrls: ['./pick-card-pack.component.css']
})
export class PickCardPackComponent implements OnInit {
  cardsInPack: Card[];
  constructor(
    public ps: PackService
  ) { }

  ngOnInit(): void {
    document.getElementById('pack-btns').style.display = 'block';
    document.getElementById('pack-view').style.display = 'none';
  }

  buyPack(i: number): void {
    this.ps.getCardPack(i).subscribe(
      resp => {
        this.cardsInPack = resp;
      }
    );
    
    document.getElementById('pack-btns').style.display = 'none';
    document.getElementById('pack-view').style.display = 'block';
  }
}
