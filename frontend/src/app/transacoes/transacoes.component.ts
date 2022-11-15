import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import { HttpClient } from '@angular/common/http';
import {Transacao} from './Transacao'



@Component({
  selector: 'app-transacoes',
  templateUrl: './transacoes.component.html',
  styleUrls: ['./transacoes.component.css']
})
export class TransacoesComponent implements OnInit {

  param
  transacoes : Transacao[]
  constructor(private route:ActivatedRoute, private router: Router, private http : HttpClient) { 
  }

  ngOnInit(): void {
    this.router.routeReuseStrategy.shouldReuseRoute = () => {
      return false;
    }
    this.route.params.subscribe(params => {
        this.param = params['id']; // reset and set based on new parameter this time
    });
    this.list();

  }

  list() {
    return this.http.get<Transacao[]>(`http://localhost:8080/contas/${this.param.replace(":", "")}/transacoes`).subscribe(dados => this.transacoes = dados);
  }

}
