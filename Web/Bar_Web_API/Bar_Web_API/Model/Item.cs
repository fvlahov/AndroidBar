namespace Bar_Web_API.Model
{
    public class Item
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public UnitOfMeasurement UnitOfMeasurement { get; set; }
        public int MinSupply { get; set; }
        public int CurrentSupply { get; set; }
    }
}