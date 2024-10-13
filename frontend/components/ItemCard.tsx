import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardImage, CardTitle } from "./shadcn/card";

export default function ItemCard() {
  return (
    <Card className="w-[400px]">
      <CardImage src="https://media.istockphoto.com/id/488160041/photo/mens-shirt.jpg?s=612x612&w=0&k=20&c=xVZjKAUJecIpYc_fKRz_EB8HuRmXCOOPOtZ-ST6eFvQ=" className="w-[400px] h-[200px] object-contain">

      </CardImage>
      <CardHeader>
        <CardTitle> Card Title </CardTitle>
        <CardDescription> This card does things no other card can do </CardDescription>
      </CardHeader>
      <CardContent>
        <p>
          Lorem ipsum, dolor sit amet consectetur adipisicing elit. Architecto fugiat quas aliquam nam in possimus sit, ducimus fugit porro rem deserunt ipsum! Ad mollitia autem dicta aperiam omnis cumque? Aspernatur. 
        </p>
      </CardContent>
      <CardFooter>
        <p>
          Card Footer
        </p>
      </CardFooter>
    </Card>
  )
}