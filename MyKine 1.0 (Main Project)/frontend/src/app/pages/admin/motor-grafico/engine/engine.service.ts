import * as THREE from 'three';
import { CameraHelper,DirectionalLight, HemisphereLight } from 'three';
import {ElementRef, Injectable, NgZone, OnDestroy} from '@angular/core';

import {GLTFLoader} from 'three/examples/jsm/loaders/GLTFLoader'
import { OrbitControls } from 'node_modules/three/examples/jsm/controls/OrbitControls.js';
import XYZ from 'ol/source/XYZ';

@Injectable({providedIn: 'root'})
export class EngineService implements OnDestroy {
  private canvas: HTMLCanvasElement;
  private renderer: THREE.WebGLRenderer;
  private camera: THREE.PerspectiveCamera;
  private scene: THREE.Scene;
  private light: THREE.AmbientLight;

  private cube: THREE.Mesh;

  private frameId: number = null;



  public constructor(private ngZone: NgZone) {
  }

  public ngOnDestroy(): void {
    if (this.frameId != null) {
      cancelAnimationFrame(this.frameId);
    }
    if (this.renderer != null) {
      this.renderer.dispose();
      this.renderer = null;
      this.canvas = null;
    }
  }

  public createScene(canvas: ElementRef<HTMLCanvasElement>): void {
    // The first step is to get the reference of the canvas element from our HTML document
    this.canvas = canvas.nativeElement;

    this.renderer = new THREE.WebGLRenderer({
      canvas: this.canvas,
      alpha: true,    // transparent background
      antialias: true // smooth edges
    });
    this.renderer.setSize(window.innerWidth, window.innerHeight);



    // create the scene
    this.scene = new THREE.Scene();


    /*PARA EL FUERTE -> this.camera = new THREE.PerspectiveCamera(
      75, window.innerWidth / window.innerHeight, 0.1, 1000
      );*/

    //PARA EL MUSCULOS
    this.camera = new THREE.PerspectiveCamera(
      40, window.innerWidth / window.innerHeight, 0.1, 1000
    );


    this.scene.add(this.camera);
    let me = this;

    const loader = new GLTFLoader();
    loader.load( '../../../../../assets/3DModels/3DMusculos/scene.gltf',

    function ( gltf ) {

      console.log(gltf);


      // PARA EL FUERTE -> NADA

      // PARA EL MUSCULOS ->
      gltf.scene.rotation.y += 0.6;
      gltf.scene.position.y += -100;
      //gltf.scene.position.x += -50;
      gltf.scene.scale.set(1.2,1.2,1.2);

      me.scene.add( gltf.scene );


    },
    function ( xhr ) {

      // console.log( ( xhr.loaded / xhr.total * 100 ) + '% loaded' );

    },
    function ( error ) {

      console.error( error );

    } );



    const loader2 = new GLTFLoader();
    loader2.load( '../../../../../assets/3DModels/SitioFondo/scene.gltf',

    function ( gltf ) {

      console.log(gltf);

      me.scene.add( gltf.scene );
      //gltf.scene.rotation.y += -0.6;
      gltf.scene.scale.set(90,90,50);
      gltf.scene.position.y += -86.5;
      gltf.scene.position.z += -150;

    },
    function ( xhr ) {

      // console.log( ( xhr.loaded / xhr.total * 100 ) + '% loaded' );

    },
    function ( error ) {

      console.error( error );

    } );



    // PARA EL FUERTE -> this.camera.position.set(100,0,200);


    // PARA EL MUSCULOS ->
    //this.camera.position.set(220,140,0);
    this.camera.position.set(250,100,400);




    // soft white light
    this.light = new THREE.AmbientLight(0x404040,8);
    //this.scene.add(this.light);
    //this.light.position.set(100, 10, 0);


    //HELPER
    //const helper = new CameraHelper(this.light.shadow.camera)
    this.scene.add(this.light,/* helper*/);



    const controls = new OrbitControls(this.camera, me.canvas);

  }

  public animate(): void {
    // We have to run this outside angular zones,
    // because it could trigger heavy changeDetection cycles.
    this.ngZone.runOutsideAngular(() => {
      if (document.readyState !== 'loading') {
        this.render();
      } else {
        window.addEventListener('DOMContentLoaded', () => {
          this.render();
        });
      }

      window.addEventListener('resize', () => {
        this.resize();
      });
    });
  }

  public render(): void {
    this.frameId = requestAnimationFrame(() => {
      this.render();
    });

    // this.cube.rotation.x += 0.01;
    // this.cube.rotation.y += 0.01;
    this.renderer.render(this.scene, this.camera);
  }

  public resize(): void {
    const width = window.innerWidth;
    const height = window.innerHeight;

    this.camera.aspect = width / height;
    this.camera.updateProjectionMatrix();

    this.renderer.setSize(width, height);
  }
}
