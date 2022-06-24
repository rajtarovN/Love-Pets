import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Family } from '../../../shared/models/family';
import { SinglePerson } from '../../../shared/models/single-person';

@Injectable({
  providedIn: 'root',
})
export class FormServiceService {
  private headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*',
  });

  constructor(private http: HttpClient) {}

  sendFamilyForm(form: Family): Observable<any> {
    const res = this.http.post<Family>(
      'http://localhost:8080/findPetFamilly',
      form,
      {
        headers: this.headers,
        responseType: 'json',
      }
    );
    return res;
  }

  sendSinglepersonForm(form: SinglePerson): Observable<any> {
    const res = this.http.post<SinglePerson>(
      'http://localhost:8080/findPetSinglePerson',
      form,
      {
        // header('Access-Control-Allow-Origin: *');
        headers: this.headers,
        responseType: 'json',
      }
    );
    return res;
  }
  backwardFamily(form: Family): Observable<any> {
    const res = this.http.post<Family>(
      'http://localhost:8080/familyBackward/' + form.wantedPet,
      form,
      {
        headers: this.headers,
        responseType: 'json',
      }
    );
    console.log(res, 'ovde gledajjj');
    return res;
  }
  backwardSinglePerson(form: SinglePerson): Observable<any> {
    const res = this.http.post<Family>(
      'http://localhost:8080/singleBackward/' + form.wantedPet,
      form,
      {
        headers: this.headers,
        responseType: 'json',
      }
    );
    console.log(res, 'ovde gledajjj');
    return res;
  }
}
