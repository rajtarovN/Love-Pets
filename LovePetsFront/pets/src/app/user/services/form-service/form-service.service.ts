import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Family } from '../../../shared/models/family';
import { SinglePerson } from '../../../shared/models/single-person';

@Injectable({
  providedIn: 'root',
})
export class FormServiceService {
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) {}

  sendFamilyForm(form: Family): Observable<any> {
    //todo nisam sig sta dode u <>
    const res = this.http.post<Family>(
      'http://localhost:8080/sendFamily',
      form,
      {
        headers: this.headers,
        responseType: 'json',
      }
    );
    return res;
  }

  sendSinglepersonForm(form: SinglePerson): Observable<any> {
    //todo nisam sig sta dode u <>
    const res = this.http.post<SinglePerson>(
      'http://localhost:8080/sendSinglePersonForm',
      form,
      {
        headers: this.headers,
        responseType: 'json',
      }
    );
    return res;
  }
}
