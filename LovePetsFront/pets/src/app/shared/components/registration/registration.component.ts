import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent implements OnInit {
  secondPartQuestions: FormGroup;

  name: string;
  lastName: string;
  email: string;
  password: string;

  constructor() {}

  ngOnInit(): void {}
}
