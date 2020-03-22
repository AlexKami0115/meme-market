import { Component, OnInit } from '@angular/core';
import { Trade } from '../trade';
import { TradeService } from '../services/trade.service';

@Component({
  selector: 'app-trades',
  templateUrl: './trades.component.html',
  styleUrls: ['./trades.component.css']
})
export class TradesComponent implements OnInit {
  public trades: Trade[];

  constructor(
    public tradeService: TradeService
  ) { }

  ngOnInit(): void {
    this.tradeService.getTrades().subscribe(
      resp => {
        this.trades = resp;
        console.log(this.trades);
      }
    )
  }

}
