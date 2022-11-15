import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Conta } from './Conta';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  contas : Conta[];
  title = 'frontend';


  constructor(private http : HttpClient){}


  ngOnInit(): void {
    this.list()
  }
  list() {
      return this.http.get<Conta[]>("http://localhost:8080/contas").subscribe(dados => this.contas = dados);
  }
}


