import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { UserLogin } from '../../../shared/models/user-login';
import { UserRegister } from '../../../shared/models/usre-register';
import { UserWithToken } from '../../../shared/models/user-with-token';
import { environment } from '../../../../environments/environment'; // environments/environment';

@Injectable({
  providedIn: 'root',
})
export class UsesrServiceService {
  private headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*',
  });

  loggedUser = new BehaviorSubject<UserWithToken>(
    JSON.parse(localStorage.getItem('currentUser')!)
  );

  constructor(private http: HttpClient) {}

  login(auth: UserLogin): Observable<UserWithToken> {
    return this.http.post<UserWithToken>('http://localhost:8080/login', auth, {
      headers: this.headers,
      responseType: 'json',
    });
  }

  register(auth: UserRegister): Observable<any> {
    //auth,
    const res = this.http.post<any>('http://localhost:8080/register', auth, {
      headers: this.headers,
      responseType: 'text' as 'json',
    });
    console.log(res, 'aaa');
    return res;
  }
}
