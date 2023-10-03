import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { PagenotFoundComponent } from './pagenot-found/pagenot-found.component';
import { AngularTutorialComponent } from './angular-tutorial/angular-tutorial.component';
import { PipeExampleComponent } from './pipe-example/pipe-example.component';
import { DirectiveExampleComponent } from './directive-example/directive-example.component';
import { ProductComponent } from './product/product.component';



const routes: Routes = [
  {
    path : '',
    redirectTo : '/home',
    pathMatch : 'full' 
  },
  {
    path: 'home',
    component : HomeComponent,
  },
  {
    path : 'about',
    component : AboutComponent,
  },
  {
    path : 'angulartut',
    component : AngularTutorialComponent,
    children : [
          {
            path : 'pipe',
            component : PipeExampleComponent
          },
          {
            path : 'directive',
            component : DirectiveExampleComponent
          }
    ]
  },
  {
    path : "product",
    component : ProductComponent
  },
  {
    path : "**",
    component : PagenotFoundComponent
  }
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
