// BOTELLA MARTINEZ, JAVIER

#include "LNear.h"

LNear::NodoL::NodoL()
{
	loc = Localidad();
	dis = -1;
	next = NULL;
	prev = NULL;
}

LNear::NodoL::NodoL(Localidad n)
{
	loc = n;
	dis = -1;
	next = NULL;
	prev = NULL;
}

LNear::NodoL::NodoL(const NodoL &a)
{
	*this = a;
}

LNear::NodoL::~NodoL()
{
	loc = Localidad();
	dis = -1;
	next = NULL;
	prev = NULL;
}

LNear::NodoL& LNear::NodoL::operator=(const NodoL &a)
{
	if(this != &a)
	{
		loc = a.loc;
		dis = a.dis;
		next = a.next;
		prev = a.prev;
	}

	return *this;
}

LNear::LNear()
{
	pr = NULL;
	ul = NULL;
	error = Localidad();
}

LNear::LNear(const LNear &a)
{
	*this = a; 
}

LNear::~LNear()
{
	if(pr != NULL)
		this->borraLocalidades(-99999);

	pr = NULL;
	ul = NULL;
	error = Localidad();
}

LNear & LNear::operator=(const LNear &a)
{
	if(this != &a)
	{
		if(pr != NULL)
		{
			borraLocalidades(-99999);
		}

		if(a.pr != NULL)
		{
			insertaLocalidad(a.pr->loc.getNombre(), a.pr->dis);

			LNear::NodoL *aux = a.pr;

			while(aux != NULL)
			{
				insertaLocalidad(aux->loc.getNombre(), aux->dis);
				aux = aux->next;
			}
		}

		error = a.error;
	}

	return *this;
}

bool LNear::esVacia()
{
	bool ret = false;

	if(pr == NULL)
		ret = true;

	return ret;
}

int LNear::rango()
{
	int ret = -1;

	if(ul != NULL)
		ret = ul->dis;

	return ret;
}

void LNear::insertaLocalidad(Localidad p, int d)
{
	if(pr != NULL)
	{
		bool sal = false;
		LNear::NodoL *aux = pr;

		int size = this->size();	

		for(int i = 0; !sal && i < size; i++)
		{
			if(aux->dis < d)
			{
				if(size == i+1)
				{
					LNear::NodoL *temp = new LNear::NodoL(p);
					temp->dis = d;

					temp->prev = aux;
					aux->next = temp;
					ul = temp;

					sal = true;
				}
				else
					aux = aux->next;
			}
			else if(aux->dis > d)
			{
				LNear::NodoL *temp = new LNear::NodoL(p);
				temp->dis = d;

				temp->next = aux;
				temp->prev = aux->prev;

				if(aux->prev != NULL)
					aux->prev->next = temp;

				aux->prev = temp;

				if(i == 0)
					pr = temp;

				sal = true;
			}
			else if(aux->dis == d && p.getNombre() == aux->loc.getNombre())
			{
				sal = true;
			}
			else if(aux->dis == d && p.getNombre() != aux->loc.getNombre())
			{
				if(p.getNombre() < aux->loc.getNombre())
				{
					LNear::NodoL *temp = new LNear::NodoL(p);
					temp->dis = d;

					temp->next = aux;
					temp->prev = aux->prev;

					if(aux->prev != NULL)
						aux->prev->next = temp;

					aux->prev = temp;

					if(i == 0)
						pr = temp;
					sal = true;
				}
				else if(aux->next != NULL && aux->next->dis == d)
				{
					aux = aux->next;
				}
				else if((aux->next != NULL && aux->next->dis != d) || (aux->next == NULL))
				{
					LNear::NodoL *temp = new LNear::NodoL(p);
					temp->dis = d;

					temp->prev = aux;
					temp->next = aux->next;

					if(aux->next != NULL)
						aux->next->prev = temp;

					aux->next = temp;

					if(ul == aux)
						ul = temp;

					sal = true;
				}
			}
		}	
	}
	else
	{
		LNear::NodoL *temp = new LNear::NodoL(p);
		temp->dis = d;
		pr = temp;
		ul = pr;
	}
}

int LNear::borraLocalidad(string s)
{
	int ret = -1;

	if(pr != NULL)
	{
		bool sal = false;
		LNear::NodoL *aux = pr;

		while(aux != NULL && !sal)
		{
			if(aux->loc.getNombre() == s)
			{
				sal = true;

				if(aux == ul)
					ul = aux->prev;
				if(aux == pr)
					pr = aux->next;
				if(aux->prev != NULL)
					aux->prev->next = aux->next;
				if(aux->next != NULL)
					aux->next->prev = aux->prev;

				ret = aux->dis;

				delete aux;
			}
			else
				aux = aux->next;
		}
	}

	return ret;
}

void LNear::borraLocalidades(int k)
{
	if(ul != NULL)
	{
		bool sal = false;

		LNear::NodoL *aux = ul;
		
		while(!sal)
		{
			
			if(aux != NULL && aux->dis > k)
			{
				ul = aux->prev;
				if(aux->prev != NULL)
				{
					LNear::NodoL *aux2 = aux;
					aux = aux->prev;

					delete aux2;

					
					
					if(aux != NULL)
						aux->next = NULL;
				}
				else
				{
					pr = NULL;
					ul = NULL;

					delete aux;

					sal = true;
				}
			}
			else if((aux != NULL && aux->dis <= k) || aux == NULL)
				sal = true;
		}
	}
}

Localidad & LNear::getLocalidad(int i)
{
	if(pr != NULL && i < this->size() && i >= 0)
	{
		LNear::NodoL *aux = pr;
		int cont = 0;

		while(aux != NULL)
		{
			if(cont == i)
				return aux->loc;
			else
			{
				aux = aux->next;
				cont++;
			}
		}
	}

	return error;
}

int LNear::size()
{
	int size = 0;
	if(pr != NULL)
	{
		LNear::NodoL *temp = pr;

		while(temp != NULL)
		{
			size++;
			temp = temp->next;
		}
	}

	return size;
}

int LNear::getDis(int i)
{
	if(pr != NULL && i < this->size() && i >= 0)
	{
		LNear::NodoL *aux = pr;

		bool sal = false;
		int cont = 0;

		while(aux != NULL && !sal)
		{
			if(cont == i)
				return aux->dis;
			else
			{
				aux = aux->next;
				cont++;
			}
		}
	}

	return -1;
}

ostream& operator<<(ostream &out, const LNear &a)
{
	if(a.pr !=NULL)
	{
		LNear::NodoL *aux = a.pr;

		cout << *aux << "\n";

		/* cout << aux->prev << "\n";
		cout << aux << "\n";
		cout << aux->next << "\n\n"; */

		while(aux != a.ul)
		{
			aux = aux->next;
			cout << *aux << "\n";

			/* cout << aux->prev << "\n";
			cout << aux << "\n";
			cout << aux->next << "\n\n"; */
		}
	}

	return out;
}

ostream& operator<<(ostream &out, LNear::NodoL &a)
{
	out << a.loc.getNombre() << " (" << a.dis << ")";
	return out;
}