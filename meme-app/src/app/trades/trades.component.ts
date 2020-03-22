import { Component, OnInit } from '@angular/core';
import { Trade } from '../trade';

@Component({
  selector: 'app-trades',
  templateUrl: './trades.component.html',
  styleUrls: ['./trades.component.css']
})
export class TradesComponent implements OnInit {
  public trades: Trade[];

  constructor() { }

  ngOnInit(): void {
    
  }

}
